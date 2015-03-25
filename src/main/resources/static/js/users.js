function addUser() {
	$('#userDialog').dialog("option", "title", 'Add User');
	$('#userDialog').dialog('open');
}

function editUser(id) {

	$.get("/users/get/" + id, function(result) {

		$("#userDialog").html(result);

		$('#userDialog').dialog("option", "title", 'Edit User');

		$("#userDialog").dialog('open');
	});
}

function resetDialog(form) {

	form.find("input").val("");
}

$(document).ready(function() {

	$('#userDialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 440,
		buttons : {
			"Save" : function() {
				$('#userForm').submit();
			},
			"Cancel" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			resetDialog($('#userForm'));

			$(this).dialog('close');
		}
	});
});
