LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8facdcfbc2d47ee6d241fae84361af0e"

SRC_URI = "http://mirrors.kodi.tv/build-deps/sources/${PN}-${PV}.tar.gz"
SRC_URI[md5sum] = "7de3be575744da5f1098295485ef0741"
SRC_URI[sha256sum] = "3d77d09a5df0de510aeeb940df4cb534787ddff3bb1828779753f5dfa1229d10"

DEPENDS = "util-linux"

PV = "8f399e8bd4"

CXXFLAGS += "-std=c++11"

do_compile (){
    ${CXX} -c guid.cpp -o guid.o ${CXXFLAGS} -DGUID_LIBUUID
    ${AR} rvs lib${PN}.a guid.o
}

do_install() {
    install -Dm 775 ${S}/guid.h ${D}${includedir}/guid.h
    install -Dm 775 ${B}/lib${PN}.a ${D}${libdir}/lib${PN}.a
}
