FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI += "file://tinyxml.pc"
inherit pkgconfig
do_install_append() {
    install -Dm 0644 ${WORKDIR}/tinyxml.pc ${D}${libdir}/pkgconfig/tinyxml.pc
}
