function addPresentation() {
	$('#presentationDialog').dialog("option", "title", 'Add Presentation');
	$('#presentationDialog').dialog('open');
}

function editPresentation(id) {

	$.get("get/" + id, function(result) {

		$("#presentationDialog").html(result);

		$('#presentationDialog').dialog("option", "title", 'Edit Presentation');

		$("#presentationDialog").dialog('open');

		initializeDatePicker();
	});
}

function initializeDatePicker() {
	$(".datepicker").datepicker({
		dateFormat : "yy-mm-dd",
		changeMonth : true,
		changeYear : true,
		showButtonPanel : true
	});
}

function resetDialog(form) {

	form.find("input").val("");
}

$(document).ready(function() {

	$('#presentationDialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 440,
		buttons : {
			"Save" : function() {
				$('#presentationForm').submit();
			},
			"Cancel" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			resetDialog($('#presentationForm'));

			$(this).dialog('close');
		}
	});

	initializeDatePicker();
});
