package core.builder;

import core.Log;
import core.annotations.ParentXpath;
import org.openqa.selenium.support.FindBy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;

public class PageBuilder<T extends WebObject> {

    T page;
    Class<? extends WebObject> pageClass;

    public PageBuilder(T page) {
        this.page = page;
    }

    public void initElements() {
        //FIXME
        String parentXpathValue = "";
        pageClass = page.getClass();
        ParentXpath parentXpath = pageClass.getDeclaredAnnotation(ParentXpath.class);
        if(parentXpath != null) {
            parentXpathValue = parentXpath.value();
            Log.debug("Setting parent xpath value to: " + parentXpathValue);
        }
        if(!Objects.equals(parentXpathValue, "")) {
            setParentXpathToElements(parentXpathValue);
        }
//        for (Field field : pageClass.getDeclaredFields()) {
//            if (Modifier.isPrivate(field.getModifiers())) {
//                field.setAccessible(true);
//            }
//            field.getAnnotations();
//            Map<Class<? extends Annotation>, Annotation> annotationsMap = getAnnotationsMap(field);
//            annotationsMap.put(FindBy.class, new FindByHandler("1234"));
//            FindBy findby = field.getDeclaredAnnotation(FindBy.class);
////TODO Add Selenium PageFactory init (with page)
//        }
    }
    private void setParentXpathToElements(String parentXpath) {
        for(Field field : pageClass.getDeclaredFields()) {
            FindBy fieldFindBy = field.getDeclaredAnnotation(FindBy.class);
            System.out.println();
        }
    }

    private Map<Class<? extends Annotation>, Annotation> getAnnotationsMap(Field f) {
//        Method method = null;
//        try {
//            method = Field.class.getDeclaredMethod("declaredAnnotations", null);
//            method.setAccessible(true);
//            method.invoke(f);
//            Field annotations = Field.class.getDeclaredField("declaredAnnotations");
//            annotations.setAccessible(true);
//            return (Map<Class<? extends Annotation>, Annotation>) annotations.get(f);
//        } catch (NoSuchMethodException | NoSuchFieldException | IllegalAccessException | InvocationTargetException e) {
//            throw new RuntimeException(e); //FIXME handle errors properly
//        }
        return null;
    }
}
