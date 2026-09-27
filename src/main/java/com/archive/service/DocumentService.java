package com.archive.service;

import com.archive.model.Document;
import com.archive.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DocumentService {
    
    @Autowired
    private DocumentRepository documentRepository;
    
    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }
    
    public Document getDocumentById(Long id) {
        return documentRepository.findById(id).orElse(null);
    }
    
    public Document createDocument(Document document) {
        return documentRepository.save(document);
    }
    
    public Document updateDocument(Long id, Document documentDetails) {
        Document document = documentRepository.findById(id).orElse(null);
        if (document != null) {
            document.setTitle(documentDetails.getTitle());
            document.setDescription(documentDetails.getDescription());
            document.setAuthor(documentDetails.getAuthor());
            document.setDocumentDate(documentDetails.getDocumentDate());
            document.setCategory(documentDetails.getCategory());
            document.setAccessLevel(documentDetails.getAccessLevel());
            document.setStatus(documentDetails.getStatus());
            document.setTags(documentDetails.getTags());
            return documentRepository.save(document);
        }
        return null;
    }
    
    public void deleteDocument(Long id) {
        documentRepository.deleteById(id);
    }
    
    public List<Document> searchDocuments(String keyword) {
        return documentRepository.searchByKeyword(keyword);
    }
    
    public List<Document> getDocumentsByCategory(Long categoryId) {
        return documentRepository.findByCategoryId(categoryId);
    }
}
