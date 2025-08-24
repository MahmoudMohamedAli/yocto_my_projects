# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b6ff1e26b9bc5eaf6e4c914ec1e3b327"

SRC_URI = "git://github.com/mycpptutorial/helloworld-cmake.git;protocol=https;branch=master \
            "

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "3813d84fd5e0af2419297d7bc40b705df1509ba0"

S = "${WORKDIR}/git"

inherit cmake

do_install(){
    
    install -d ${D}${bindir}
    
    install -m 0755 ${WORKDIR}/build/greet  ${D}${bindir}
}

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = ""

