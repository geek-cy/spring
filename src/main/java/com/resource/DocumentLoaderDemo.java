package com.resource;

import org.springframework.beans.factory.xml.DefaultDocumentLoader;
import org.springframework.beans.factory.xml.DocumentLoader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.w3c.dom.*;
import org.xml.sax.InputSource;

import java.io.IOException;
import java.io.InputStream;

/**
 * 用于加载和解析 XML 文档
 */
public class DocumentLoaderDemo {
    public static void main(String[] args) throws Exception {
        DocumentLoader documentLoader = new DefaultDocumentLoader();
        Resource resource = new ClassPathResource("applicationContext.xml");
        Document document = documentLoader.loadDocument(new InputSource(resource.getInputStream()),
                null, null, 0, true);
        printDetailedDocumentInfo(document);
    }

    private static void printDetailedDocumentInfo(Document document) {
        // Element是元素节点
        Element documentElement = document.getDocumentElement();
        printElementInfo(documentElement);
    }

    private static void printElementInfo(Element documentElement) {
        // 打印元素名称
        System.out.println("Element node name: " + documentElement.getNodeName());
        // 打印元素的属性
        NamedNodeMap attributes = documentElement.getAttributes();
        for (int i = 0; i < attributes.getLength(); i++) {
            Node attribute = attributes.item(i);
            System.out.println(attribute.getNodeName() + ": " + attribute.getNodeValue());
        }
        // 打印元素的子节点
        NodeList childNodes = documentElement.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node childNode = childNodes.item(i);
            // Print the child node
            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                // Print the element
                printElementInfo((Element) childNode);
            } else if (childNode.getNodeType() == Node.TEXT_NODE) {
                // Print the text
                System.out.println("Text node value: " + childNode.getNodeValue());
            }
        }
    }
}
