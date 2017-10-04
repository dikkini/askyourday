function notySuccess(text, killer) {
    noty(text, 'success', killer);
}

function notyError(text, killer) {
    noty(text, 'error', killer);
}

function notyWarning(text, killer) {
    noty(text, 'warning', killer);
}

function noty(text, type, killer) {
    var noty = new Noty({
        text: text,
        type: type,
        layout: 'topRight',
        theme: 'relax',
        timeout: '5000',
        killer: killer
    });

    noty.show();
}