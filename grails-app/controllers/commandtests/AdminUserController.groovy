package commandtests

import grails.validation.Validateable


class AdminUserController {

	def save(UserCommand command) {
		if (command.hasErrors()) {
			render view: 'create', model: [command: command]
			return
		}

		User user = userService.createUser(command.properties + [selectedAutomatonServer: userService.currentUser.selectedAutomatonServer])
		flash.success = message(code: 'default.created.message', args: [message(code: 'user.label'), user.id])
		redirect action: 'list'
	}


}

class UserCommand implements Validateable{
	String firstName
	String lastName
	String username
	String password
	boolean enabled

	static constraints = {
		firstName shared: 'nonNullableString'
		lastName shared: 'nonNullableString'
		username shared: 'nonNullableEmail'
		password shared: 'nullableString'
	}
}
