FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " \
    file://weston.default \
"

do_install_append() {
    install -d ${D}/${sysconfdir}/default
    install -m 644 ${WORKDIR}/weston.default ${D}/${sysconfdir}/default/weston

    sed -e "s/PAMName/#PAMName/" \
           -i ${D}/${systemd_system_unitdir}/weston.service
}
