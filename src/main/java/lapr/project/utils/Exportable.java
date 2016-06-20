package lapr.project.utils;

//import org.w3c.dom.Node;
//import javax.xml.transform.TransformerException;
/**
 * Interface that allows object's content to be exported.
 *
 * @author Nuno Bettencourt [nmb@isep.ipp.pt] on 29/05/16.
 *
 * Changed by:
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
//@FunctionalInterface
public interface Exportable {

    /**
     * Get some part of exportable information
     *
     * @return
     */
    String getData();

    /**
     * Exports with help of JAXB library the object to a XML file.
     *
     * @param path the path where the file will be saved
     */
    void jaxbObjectExportableToXML(String path);

//	/**
//	 * Exports the object content to a string format.
//	 *
//	 * @return Structured String containing content.
//	 */
//	default String exportContentToString() {
//		String content = "";
//
//		Node node = exportContentToXMLNode();
//
//		XMLParser xmlParser = new XMLParser();
//
//		try {
//			//It exports only the element representation to XML, ommiting the XML header
//			content = xmlParser.convertToString(node);
//		} catch (TransformerException e) {
//			e.printStackTrace();
//		}
//
//		return content;
//	}
//
//	/**
//	 * Exports the object content to a string format.
//	 *
//	 * @return Structured String containing content.
//	 */
//	Node exportContentToXMLNode();
}
