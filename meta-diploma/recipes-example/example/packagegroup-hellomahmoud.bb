DESCRIPTION = "Test package groups"

LICENSE = "CLOSED"

SUMMARY = "Package group for meta-diploma"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup


RDEPENDS_${PN} = " \
    hellomahmoud-src \
    hellomahmoud-doc \
    hellomahmoud-bin \
    hello-make \
    helloworld \
"
