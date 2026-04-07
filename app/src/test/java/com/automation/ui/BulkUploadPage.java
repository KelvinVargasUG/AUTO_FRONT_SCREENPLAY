package com.automation.ui;

import net.serenitybdd.screenplay.targets.Target;

public class BulkUploadPage {

    public static final Target NAV_BULK_UPLOAD_LINK =
            Target.the("enlace de navegación a Carga Masiva")
                  .locatedBy("[data-testid='nav-bulk-upload']");

    public static final Target DROP_ZONE =
            Target.the("zona de carga de archivo CSV")
                  .locatedBy("[data-testid='csv-drop-zone']");

    public static final Target FILE_INPUT =
            Target.the("input de selección de archivo CSV")
                  .locatedBy("[data-testid='csv-file-input']");

    public static final Target DOWNLOAD_TEMPLATE_BUTTON =
            Target.the("botón descargar plantilla CSV")
                  .locatedBy("[data-testid='download-template-btn']");

    public static final Target UPLOAD_SUMMARY_TITLE =
            Target.the("título del panel de resultado")
                  .locatedBy("[data-testid='upload-summary-title']");

    public static final Target UPLOAD_ERROR_MESSAGE =
            Target.the("mensaje de error de carga")
                  .locatedBy("//html/body/div/div/div/div/div[3]/p");

    public static final Target UPLOAD_SIZE_ERROR =
            Target.the("mensaje de error por exceso de tamaño")
                  .locatedBy("[data-testid='upload-size-error']");

    public static final Target ERROR_REPORT_LINK =
            Target.the("enlace descarga reporte de registros inválidos")
                  .locatedBy("//html/body/div/div/div/div/div[2]/div/button");
}
