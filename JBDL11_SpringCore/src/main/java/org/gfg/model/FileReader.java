package org.gfg.model;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class FileReader  /*implements InitializingBean, DisposableBean */{

    String content;

  /*  public void initMethod(){
        System.out.println("Init method, opening the file");
    }

    public void destroyMethod(){
        System.out.println("Destroy method, closing the file");
    }
*/


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

 /*   @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Init method, opening the file");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Destroy method, closing the file");
    }
  */


    @PostConstruct
    public void annotationInitMethod(){
        System.out.println("Init method, opening the file");
    }

    @PreDestroy
    public void annotationDestroyMethod(){
        System.out.println("Destroy method, closing the file");
    }
}
