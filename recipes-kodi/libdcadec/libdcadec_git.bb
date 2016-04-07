SUMMARY = "DTS Coherent Acoustics decoder with support for HD extensions"
SECTION = "libs"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING.LGPLv2.1;md5=4fbd65380cdd255951079008b364516c"
SRC_URI = "git://github.com/foo86/dcadec.git"
SRCREV = "8a7598606d16d34a53058ee3adbbc91db0023dfc"

S = "${WORKDIR}/git"

do_configure () {
}

CFLAGS += "-std=gnu99"
export PREFIX="${prefix}"

do_compile (){
	oe_runmake
}

do_install() {
	oe_runmake DESTDIR=${D} install
}

BBCLASSEXTEND = "native nativesdk"
