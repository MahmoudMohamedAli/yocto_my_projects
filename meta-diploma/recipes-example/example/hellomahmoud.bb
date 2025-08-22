SUMMARY = "Hello Mahmoud program"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = " "

SRC_URI = "file://main.c \
           file://README.txt \
           file://MAN.txt"
S = "${WORKDIR}"


do_compile() {
    bbwarn "do_compile() hello mahmoud from do_compile"
    ${CC} ${CFLAGS} ${LDFLAGS} -o hellomahmoud ${WORKDIR}/main.c -DCONFIG_VALUE=21
}

do_install() {
    bbwarn "do_install() hello mahmoud from do_install"
    install -d ${D}${bindir}
    install -d ${D}${docdir}
   
    install -d ${D}${infodir}
   
    install -m 0755 ${WORKDIR}/hellomahmoud ${D}${bindir}/hellomahmoud
    install -m 0755 ${WORKDIR}/README.txt   ${D}${docdir}/README.txt
   
    install -m 0755 ${WORKDIR}/MAN.txt   ${D}${infodir}/man.txt
    
  #  install -d ${D}/usr/src/debug/${PN}/${PV}-${PR}
   # install -m 0644 main.c ${D}/usr/src/debug/${PN}/${PV}-${PR}/
}


# Ensure the package includes the binary
FILES_${PN} += "${bindir}/hellomahmoud"

# Declare custom subpackage
PACKAGES =+ "${PN}-bin"

# Add them to -bin
FILES:${PN}-bin += "${infodir}/man.txt"

# Remove man pages from -doc
FILES:${PN}-doc:remove = "${infodir}/man.txt"



#FILES:${PN}-doc += "/usr/src/debug/${PN}/${PV}-${PR}"
#FILES:${PN}-doc += "/usr/src"

#FILES:${PN}-doc += "/usr/src/debug/${PN}/${PV}-${PR}"

# Remove main.c from -src package if it would otherwise be included
#FILES:${PN}-src:remove += "/usr/src/debug/${PN}/${PV}-${PR}"

#FILES:${PN}-src:remove += "/usr/src/debug/${PN}/${PV}-${PR}"
#FILES:${PN}-src:remove += "/usr/src"