// list of uploaded files were uploaded
var uploadedFileList = [];

// dict of added files. key is file and value is done function which launches upload process
var addedFilesHash = {};

$(document).ready(function () {
	var count = 0;
	Dropzone.autoDiscover = false;
	var myDropzone = new Dropzone("#file_upload-form", {
		paramName: "file", // The name that will be used to transfer the file
		addRemoveLinks: true,
		maxFilesize: 5, // MB
		parallelUploads: 5,
		uploadMultiple: true,
		acceptedFiles: "image/*,.xlsx,.xls,.pdf,.doc,.docx",
		maxFiles: 10,
		accept: function (file, done) {
			var _id = count++;
			file._id = _id;
			addedFilesHash[_id] = done;
		},
		init: function () {
			this.on("successmultiple", function (files, response) {
				for (var i = 0; i < files.length; i++) {
					files[i].id = response[i].id;
					uploadedFileList.push(response[i]);
				}
			});

			this.on("removedfile", function (file) {
				var deleteFileId = file.id;
				// delete uploaded files (they wont be deleted from server at this moment)
				uploadedFileList = uploadedFileList.filter(function(el) {
					return el.id !== deleteFileId;
				});
				// delete added (not uploaded) files
				delete addedFilesHash[file._id];
			});

			this.on("queuecomplete", function (file) {
				onFilesUploadComplete();
			});
		}
	});

	$("#hidden-files").children().each(function () {
		var file = {
			id: $(this).attr("data-id"),
			name: $(this).attr("data-name"),
			contentType: $(this).attr("data-content_type"),
			size: $(this).attr("data-size")
		};

		uploadedFileList.push(file);

		var dzFile = $.extend( true, {}, file );

		dzFile.status = Dropzone.SUCCESS;
		dzFile.accepted = true;
		dzFile.content_type = $(this).attr("data-content_type");

		myDropzone.options.addedfile.call(myDropzone, dzFile);
		myDropzone.options.complete.call(myDropzone, dzFile);
		myDropzone.options.success.call(myDropzone, dzFile);
		myDropzone.options.thumbnail.call(myDropzone, dzFile, "/file/get/" + file.id);
	});
});