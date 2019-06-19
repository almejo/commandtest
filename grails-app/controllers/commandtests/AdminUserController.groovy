package commandtests

import grails.validation.Validateable


class AdminUserController {

	def save(UserCommand command) {
		if (command.hasErrors()) {
			render view: 'create', model: [command: command]
			return
		}

		new User(firstName: command.firstName).save()
		flash.success = message(code: 'default.created.message')
		redirect action: 'list'
	}


}

class UserCommand implements Validateable{
	String firstName

	static constraints = {
		firstName shared: 'nonNullableString'
	}
}
