/****************************************************************************************************
 * File name: ColorConverter.java
 * Author: Vitalii Poliakov (040941169)
 * Course: CST8218 - Web Enterprise Application, Section: 302
 * Assignment: 2
 * Date: 2020 November 21
 * Professor: Todd Kelley
 * Purpose: Converts users input into a Color
 ****************************************************************************************************/

package service;

import java.awt.Color;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter("convert")
public class ColorConverter implements Converter {
    /** Converts a string value into a Color object.
     * @param context FacesContext for the request being processed
     * @param component UIComponent with which this model object value is associated
     * @param value String value to be converted
     * @return an Object containing the result of the conversion
     */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return Color.decode("#"+value);
    }
    /** Converts a specified Color object into a String.
     * @param context FacesContext for the request being processed
     * @param component UIComponent with which this model object value is associated
     * @param value Model object value to be converted 
     * @return a String containing the result of the conversion
     */
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Color color = (Color) value;
        return Integer.toHexString(color.getRGB()).substring(2);
    }
}