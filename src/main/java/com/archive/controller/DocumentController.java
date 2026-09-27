package com.archive.controller;

import com.archive.model.Document;
import com.archive.service.DocumentService;
import com.archive.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@RestController
@RequestMapping("/api/documents")
@CrossOrigin(origins = "*")
public class DocumentController {
    
    @Autowired
    private DocumentService documentService;
    
    @Autowired
    private FileStorageService fileStorageService;
    
    @GetMapping
    public List<Document> getAllDocuments() {
        return documentService.getAllDocuments();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Document> getDocumentById(@PathVariable Long id) {
        Document document = documentService.getDocumentById(id);
        return document != null ? ResponseEntity.ok(document) : ResponseEntity.notFound().build();
    }
    
    @PostMapping("/upload")
    public ResponseEntity<Document> uploadDocument(
            @RequestParam("file") MultipartFile file,
            @RequestParam("title") String title,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "author", required = false) String author,
            @RequestParam(value = "categoryId", required = false) Long categoryId
    ) {
        try {
            String filename = fileStorageService.storeFile(file);
            Document document = new Document();
            document.setTitle(title);
            document.setDescription(description);
            document.setAuthor(author);
            document.setFilePath(filename);
            document.setFileType(file.getContentType());
            document.setFileSize(file.getSize());
            Document saved = documentService.createDocument(document);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Document> updateDocument(@PathVariable Long id, @RequestBody Document document) {
        Document updated = documentService.updateDocument(id, document);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocument(@PathVariable Long id) {
        documentService.deleteDocument(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/search")
    public List<Document> searchDocuments(@RequestParam String keyword) {
        return documentService.searchDocuments(keyword);
    }
    
    @GetMapping("/category/{categoryId}")
    public List<Document> getDocumentsByCategory(@PathVariable Long categoryId) {
        return documentService.getDocumentsByCategory(categoryId);
    }
}
