package commandtests

import grails.testing.gorm.DomainUnitTest
import org.apache.commons.lang.RandomStringUtils
import spock.lang.Specification


class UserSpec extends Specification implements DomainUnitTest<User>{
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
