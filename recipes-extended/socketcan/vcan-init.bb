SUMMARY = "Setup script and systemd unit file for the vcan device"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "file://vcan.service \
           file://vcan-setup"

inherit systemd

S = "${WORKDIR}/${BPN}-${PV}"

do_install() {
	install -d ${D}/usr/libexec
	install -m 0755 ${WORKDIR}/vcan-setup ${D}/usr/libexec

	install -d ${D}${systemd_system_unitdir}
	install -m 0644 ${WORKDIR}/vcan.service ${D}${systemd_system_unitdir}/vcan.service
}

FILES_${PN} += " ${systemd_unitdir} /usr/libexec/* "

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "vcan.service"
