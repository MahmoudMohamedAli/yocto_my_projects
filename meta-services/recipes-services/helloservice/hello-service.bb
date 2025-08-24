# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# Unable to find any files that looked like license statements. Check the accompanying
# documentation and source headers and set LICENSE and LIC_FILES_CHKSUM accordingly.
#
# NOTE: LICENSE is being set to "CLOSED" to allow you to at least start building - if
# this is not accurate with respect to the licensing of the software being built (it
# will not be in most cases) you must specify the correct value before using this
# recipe for anything other than initial testing/development!
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

inherit systemd

# No information for SRC_URI yet (only an external source tree was specified)
SRC_URI = "file://main.c \
           file://Makefile \
		   file://hello.service \
			"

# NOTE: this is a Makefile-only piece of software, so we cannot generate much of the
# recipe automatically - you will need to examine the Makefile yourself and ensure
# that the appropriate arguments are passed in.

S = "${WORKDIR}"


do_configure () {
	# Specify any needed configure commands here
	:
}

do_compile () {
	# You will almost certainly need to add additional arguments here
	oe_runmake
}

# Install binary and service
do_install() {
	#echo ">>> D is: ${D}" >> ${T}/log.do_install
    oe_runmake install DESTDIR=${D}
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/hello.service ${D}${systemd_system_unitdir}/
}

# Tell Yocto about the service
SYSTEMD_SERVICE_${PN} = "hello.service"
SYSTEMD_AUTO_ENABLE = "enable"
