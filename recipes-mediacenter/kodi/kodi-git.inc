SRC_URI = "git://github.com/xbmc/xbmc.git;branch=${BRANCH}"
BRANCH = "Jarvis"
SRCREV="beac3476d3a782daab6724db0e22231f74591bf3"
PV = "16.1+gitr${SRCPV}"

PATCHTOOL = "git"
S = "${WORKDIR}/git"
