# Digital Archive Management System 📚

A comprehensive document digitization and archive management system built with **Java Spring Boot**, **React**, and **PostgreSQL**.

## Project Structure

```text
digital-archive-management-system/
├── backend/
│   ├── src/main/java/.../
│   │   ├── config/
│   │   ├── security/
│   │   ├── controller/
│   │   ├── service/
│   │   ├── repository/
│   │   ├── entity/
│   │   ├── dto/
│   │   └── exception/
│   ├── src/main/resources/
│   │   └── application.properties
│   └── pom.xml
├── frontend/
│   ├── src/
│   │   ├── api/
│   │   ├── components/
│   │   ├── pages/
│   │   ├── features/
│   │   │   ├── documents/
│   │   │   ├── categories/
│   │   │   └── search/
│   │   ├── hooks/
│   │   └── routes/
│   └── package.json
├── database/
│   └── schema.sql
├── storage/
├── README.md
└── .gitignore
```

## Features

-   **Document Digitization**: Upload PDF and image files with metadata
-   **Advanced Metadata Management**: Title, author, date, categories, tags, descriptions
-   **Full-Text Search**: Search across document titles, descriptions, and authors
-   **Hierarchical Categories**: Organize documents in nested category structures
-   **Access Control**: Public, Restricted, and Classified document levels
-   **Version Control**: Track document revisions and changes
-   **Document Viewer**: Browse and view uploaded documents
-   **Tag System**: Flexible tagging for cross-cutting categorization
-   **Analytics Dashboard**: Document statistics and trends
-   **Multi-Format Support**: PDF, images, and other common document formats

## Tech Stack

**Backend:**
-   Java 17+
-   Spring Boot 3.2.0
-   Spring Security (JWT authentication)
-   Spring Data JPA
-   PostgreSQL (with full-text search)
-   Maven

**Frontend:**
-   React 18
-   Material-UI (planned)
-   PDF.js (document viewer)
-   Axios
-   React Router

**File Storage:**
-   Local filesystem storage
-   Multipart file upload support (up to 50MB)

## Why This Project Stands Out

✅ **Perfect for Presidential/Historical Archives**: Designed specifically for digitization workflows  
✅ **Document Management Expertise**: Comprehensive metadata handling  
✅ **Search Capabilities**: Full-text search with PostgreSQL  
✅ **Access Control**: Multi-level security for sensitive documents  
✅ **Version Control**: Track document changes over time  
✅ **Scalable Architecture**: RESTful API design with clean separation of concerns  
✅ **Production-Ready**: Proper file handling, validation, and error management

## Setup Instructions

### Prerequisites
-   Java 17 or higher
-   PostgreSQL 12+
-   Maven 3.6+
-   Node.js 16+ (for frontend)

### Backend Setup

1.  **Create PostgreSQL database:**
    ```bash
    createdb archive_db
    ```

2.  **Run database schema:**
    ```bash
    psql -d archive_db -f database/schema.sql
    ```

3.  **Configure database credentials:**
    Edit `src/main/resources/application.properties` with your PostgreSQL credentials.

4.  **Build and run:**
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```
    API will be available at `http://localhost:8080`

### Frontend Setup

1.  **Navigate to frontend directory:**
    ```bash
    cd frontend
    ```

2.  **Install dependencies:**
    ```bash
    npm install
    ```

3.  **Start development server:**
    ```bash
    npm run dev
    ```
    App will run at `http://localhost:5173`

## API Endpoints

### Authentication
-   `POST /api/auth/register` - Register new user
-   `POST /api/auth/login` - Login and get JWT token

### Documents
-   `GET /api/documents` - Get all documents
-   `GET /api/documents/{id}` - Get document by ID
-   `POST /api/documents/upload` - Upload new document (multipart)
-   `PUT /api/documents/{id}` - Update document metadata
-   `DELETE /api/documents/{id}` - Delete document
-   `GET /api/documents/search?keyword={keyword}` - Search documents
-   `GET /api/documents/category/{categoryId}` - Get documents by category

### Categories
-   `GET /api/categories` - Get all categories
-   `POST /api/categories` - Create new category

## Key Features for Presidential Archive

1.  **Historical Document Management**: Perfect for managing archival collections
2.  **Metadata Standards**: Comprehensive metadata capture for proper cataloging
3.  **Access Levels**: Handle public, restricted, and classified documents
4.  **Search & Discovery**: Advanced search to help researchers find documents
5.  **Preservation**: Version control to track document changes and updates
6.  **Scalability**: Designed to handle large document collections

## Future Enhancements

-   OCR integration for text extraction from scanned images
-   Multi-language support (Kazakh, Russian, English)
-   Document workflow (Draft → Review → Approved)
-   Timeline visualization for historical documents
-   QR code generation for physical archive tracking
-   Bulk import/export functionality
-   Advanced analytics and reporting
