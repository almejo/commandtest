package commandtests


import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import org.apache.commons.lang.RandomStringUtils
import spock.lang.Specification

@TestFor(User)
@Mock([])
class UserSpec extends Specification {
	@SuppressWarnings("GroovyAssignabilityCheck")
	void testConstraints() {
		when:
		User user = new User()

		then:
		!user.validate()
		user.errors['firstName'].code == 'nullable'

		when:
		user = new User(
				firstName: RandomStringUtils.randomAlphabetic(256)
		)

		then:
		!user.validate()
		user.errors['firstName'].code == 'maxSize.exceeded'

		when:
		user = new User(
				firstName: RandomStringUtils.randomAlphabetic(10)
		)

		then:
		user.validate()
	}
}
