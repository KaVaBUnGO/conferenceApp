function addPresentation() {
    $('#presentationDialog').dialog("option", "title", 'Add Presentation');
    $('#presentationDialog').dialog('open');
}

function editPresentation(id) {

    $.get("get/" + id, function (result) {

        $("#presentationDialog").html(result);

        $('#presentationDialog').dialog("option", "title", 'Edit Presentation');

        $("#presentationDialog").dialog('open');

    });
}

function deletePresentation(id) {

    $( "#dialog-confirm" ).dialog({
        resizable: false,
        height:200,
        width: 300,
        modal: true,
        buttons: {
            "Delete presentation": function() {
                $.ajax({
                    url: "/presentations/delete/" + id,
                    type: "POST",
                    success:function(response) {
                        $('#presentation-'+id).hide()
                    }
                });
                $( this ).dialog( "close" );
            },
            Cancel: function() {
                $( this ).dialog( "close" );
            }
        }
    });
}

function resetDialog(form) {
    form.find("input").val("");
}

$(document).ready(function () {

    $('#presentationDialog').dialog({

        autoOpen: false,
        position: 'center',
        modal: true,
        resizable: false,
        width: 440,
        buttons: {
            "Save": function () {
                $('#presentationForm').submit();
            },
            "Cancel": function () {
                $(this).dialog('close');
            }
        },
        close: function () {

            resetDialog($('#presentationForm'));

            $(this).dialog('close');
        }
    });

});
$(function () {
var token = $("input[name='_csrf']").val();
var header = "X-CSRF-TOKEN";
$(document).ajaxSend(function(e, xhr, options) {
    xhr.setRequestHeader(header, token);
});
});
