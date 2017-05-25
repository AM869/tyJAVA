
package com.klsoukas.mavenproject8.customValidation;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.beanutils.BeanUtils;

public class MatchesValidator implements ConstraintValidator<Matches, Object> {

  private String field;
  private String verifyField;


  public void initialize(Matches constraintAnnotation) {
    this.field = constraintAnnotation.field();
    this.verifyField = constraintAnnotation.verifyField();
  }

  public boolean isValid(Object value, ConstraintValidatorContext context) {
      try {
          Object fieldObj = BeanUtils.getProperty(value, field);
          Object verifyFieldObj = BeanUtils.getProperty(value, verifyField);
          
          boolean neitherSet = (fieldObj == null) && (verifyFieldObj == null);
          
          if (neitherSet) {
              return true;
          }
          
          boolean matches = (fieldObj != null) && fieldObj.equals(verifyFieldObj);
          
          if (!matches) {
              context.disableDefaultConstraintViolation();
//              context.buildConstraintViolationWithTemplate(field+" fields do not match!")
context.buildConstraintViolationWithTemplate("{Matches}")
                      .addPropertyNode((String)verifyField)
                      .addConstraintViolation();
          }
          
          return matches;
      } catch (IllegalAccessException ex) {
          Logger.getLogger(MatchesValidator.class.getName()).log(Level.SEVERE, null, ex);
      } catch (InvocationTargetException ex) {
          Logger.getLogger(MatchesValidator.class.getName()).log(Level.SEVERE, null, ex);
      } catch (NoSuchMethodException ex) {
          Logger.getLogger(MatchesValidator.class.getName()).log(Level.SEVERE, null, ex);
      }
      
      return false;
  }
}