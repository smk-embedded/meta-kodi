LICENSE = "GPLv3 & LGPLv2.1 & BSD"
LIC_FILES_CHKSUM = "file://LICENCE-GPL-3.txt;md5=d32239bcb673463ab874e80d47fae504 \
                    file://LICENCE-LGPL-2.1.txt;md5=4fbd65380cdd255951079008b364516c \
                    file://COPYING;md5=0019ace2726c6f181791a9ac04c7ac6a \
                    file://LICENCE-BSD.txt;md5=fc3e573fccd7ce0c86aa38b46a6414b3"

SRC_URI = "git://github.com/sahlberg/libnfs"
SRCREV = "04363a9274f5895b41ddb14ac72ec3a185a94e6f"
PV = "1.10.0"

S = "${WORKDIR}/git"

inherit autotools
