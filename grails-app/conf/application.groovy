
grails.gorm.default.constraints = {

	nonNullableString(blank: false, maxSize: 255)

	nullableString(nullable: true, maxSize: 255)

}