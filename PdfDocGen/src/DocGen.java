
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.TextField;
import java.util.HashMap;

/**
 *
 * @author Melan
 */
public class DocGen {

    public static final String DATASHEET = "D:\\bb\\datasheet.pdf";
    public static final String dest = "D:\\bb\\datasheet_done.pdf";
    public static final String RESULT = "D:\\bb\\form_info.txt";
    public static byte[] USER = "Hello".getBytes();
    public static byte[] OWNER = "World".getBytes();

    public static void main(String[] args) throws IOException, DocumentException {
        PrintWriter writer = new PrintWriter(new FileOutputStream(RESULT));
        PdfReader reader = new PdfReader(DATASHEET);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        stamper.setEncryption(null, OWNER, PdfWriter.ALLOW_PRINTING | PdfWriter.ALLOW_COPY, PdfWriter.STANDARD_ENCRYPTION_128);

        stamper.getWriter().createXmpMetadata();
        AcroFields form = stamper.getAcroFields();
        Set<String> fields = form.getFields().keySet();
        for (String key : fields) {
            writer.print(key + ": ");
            writer.print(key + ": ");
            switch (form.getFieldType(key)) {
                case AcroFields.FIELD_TYPE_CHECKBOX:
                    writer.println("Checkbox");
                    break;
                case AcroFields.FIELD_TYPE_COMBO:
                    writer.println("Combobox");
                    break;
                case AcroFields.FIELD_TYPE_LIST:
                    writer.println("List");
                    break;
                case AcroFields.FIELD_TYPE_NONE:
                    writer.println("None");
                    break;
                case AcroFields.FIELD_TYPE_PUSHBUTTON:
                    writer.println("Pushbutton");
                    break;
                case AcroFields.FIELD_TYPE_RADIOBUTTON:
                    writer.println("Radiobutton");
                    break;
                case AcroFields.FIELD_TYPE_SIGNATURE:
                    writer.println("Signature");
                    break;
                case AcroFields.FIELD_TYPE_TEXT:
                    writer.println("Text");
                    break;
                default:
                    writer.println("?");
            }
        }
        form.setField("TextField1", "set by java");
        form.setField("TextField2", "set by java");
        form.setField("TextField3", "set by java");
        form.setField("TextField4", "set by java");
        form.setField("TextField5", "set by java");
        form.setField("TextField6", "set by java");
        // form.setFieldProperty("TextField4", "setOptions", TextField.READ_ONLY, null);
      //  form.regenerateField("TextField4");
        stamper.setFormFlattening(true);
        HashMap<String, String> info = reader.getInfo();
        info.put("Title", "Data  report");
        info.put("Subject", "Data  report");
        info.put("Keywords", "");
        info.put("Creator", "ActiveSplash ERP for FreeBSD");
        info.put("Author", "Melan Nimesh");
        stamper.setMoreInfo(info);
        stamper.setFullCompression();

        stamper.close();
//        writer.println("Possible values for CP_1:");
//        String[] states = form.getAppearanceStates("CP_1");
//        for (int i = 0; i < states.length; i++) {
//            writer.print(" - ");
//            writer.println(states[i]);
//        }
//
//        writer.println("Possible values for category:");
//        states = form.getAppearanceStates("category");
//        for (int i = 0; i < states.length - 1; i++) {
//            writer.print(states[i]);
//            writer.print(", ");
//        }
//        writer.println(states[states.length - 1]);

        writer.flush();
        writer.close();

    }
}
