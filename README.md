# 🎓 Student Management Portal

A comprehensive Java Spring Boot application for managing students, courses, and enrollments with a modern Thymeleaf UI. Perfect for educational institutions to manage their student data, course offerings, and academic performance.

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-brightgreen)
![Java](https://img.shields.io/badge/Java-17-orange)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-3.1.1-green)
![Bootstrap](https://img.shields.io/badge/Bootstrap-5.3.0-blue)
![H2](https://img.shields.io/badge/H2-Database-red)

## 📋 Table of Contents

- [Features](#features)
- [Technology Stack](#technology-stack)
- [Prerequisites](#prerequisites)
- [Installation & Setup](#installation--setup)
- [Running the Application](#running-the-application)
- [Application Structure](#application-structure)
- [API Endpoints](#api-endpoints)
- [Database Schema](#database-schema)
- [User Guide](#user-guide)
- [Screenshots](#screenshots)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## ✨ Features

### 🎓 Student Management
- ✅ Complete CRUD operations (Create, Read, Update, Delete)
- ✅ Unique email validation with database constraints
- ✅ Form validation with user-friendly error messages
- ✅ Search and filter capabilities

### 📚 Course Management
- ✅ Full CRUD operations for courses
- ✅ Course descriptions and metadata
- ✅ Integration with enrollment system

### 📝 Enrollment & Grading System
- ✅ Student-course enrollment management
- ✅ Grade assignment and updates
- ✅ Enrollment history tracking
- ✅ Bulk operations support

### 📊 Performance Analytics
- ✅ GPA calculation using standard grading scale
- ✅ Pass rate visualization with progress bars
- ✅ Individual student performance cards
- ✅ Course-by-course grade breakdown
- ✅ Performance trends and insights

### 🎨 User Interface
- ✅ Modern, responsive design with Bootstrap 5
- ✅ Intuitive navigation with step-by-step workflow
- ✅ Mobile-friendly responsive layout
- ✅ Dark/light theme support
- ✅ Font Awesome icons for better UX

### 🔒 Data Integrity
- ✅ Database-level constraints for data consistency
- ✅ Application-level validation
- ✅ Error handling and user feedback
- ✅ Transaction management

## 🛠 Technology Stack

### Backend
- **Framework**: Spring Boot 3.2.0
- **Language**: Java 17
- **Build Tool**: Maven
- **ORM**: Spring Data JPA with Hibernate
- **Database**: H2 (In-memory for development)

### Frontend
- **Template Engine**: Thymeleaf 3.1.1
- **CSS Framework**: Bootstrap 5.3.0
- **Icons**: Font Awesome 6.0.0
- **JavaScript**: Vanilla JS with Bootstrap components

### Development Tools
- **IDE**: VS Code / IntelliJ IDEA
- **Version Control**: Git
- **Database Tool**: H2 Console
- **API Testing**: Postman (optional)

## 📋 Prerequisites

Before running this application, make sure you have the following installed:

- **Java 17** or higher
  ```bash
  java -version
  ```
- **Maven 3.6+**
  ```bash
  mvn -version
  ```
- **Git** (for cloning the repository)
- **Web Browser** (Chrome, Firefox, Safari, Edge)

## 🚀 Installation & Setup

### 1. Clone the Repository
```bash
git clone https://github.com/your-username/student-management-portal.git
cd student-management-portal
```

### 2. Build the Project
```bash
mvn clean install
```

### 3. Verify Build Success
```bash
mvn test
```

## ▶️ Running the Application

### Method 1: Using Maven (Recommended)
```bash
mvn spring-boot:run
```

### Method 2: Using Java JAR
```bash
mvn clean package
java -jar target/student-management-portal-0.0.1-SNAPSHOT.jar
```

### Method 3: Using IDE
1. Open the project in your IDE
2. Navigate to `src/main/java/com/example/sms/Application.java`
3. Run the main method

### Access the Application
Once the application starts successfully, access it at:
- **Main Application**: http://localhost:8088
- **H2 Database Console**: http://localhost:8088/h2-console

### Stopping the Application
Press `Ctrl+C` in the terminal where the application is running.

## 🏗 Application Structure

```
student-management-portal/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/sms/
│   │   │       ├── Application.java              # Main Spring Boot application
│   │   │       ├── controller/                   # REST controllers
│   │   │       │   ├── HomeController.java       # Home page controller
│   │   │       │   ├── StudentController.java    # Student management
│   │   │       │   ├── CourseController.java     # Course management
│   │   │       │   ├── EnrollmentController.java # Enrollment management
│   │   │       │   └── PerformanceController.java # Performance analytics
│   │   │       ├── entity/                       # JPA entities
│   │   │       │   ├── Student.java              # Student entity
│   │   │       │   ├── Course.java               # Course entity
│   │   │       │   └── Enrollment.java           # Enrollment entity
│   │   │       ├── repository/                   # Data repositories
│   │   │       │   ├── StudentRepository.java    # Student data access
│   │   │       │   ├── CourseRepository.java     # Course data access
│   │   │       │   └── EnrollmentRepository.java # Enrollment data access
│   │   │       └── service/                      # Business logic
│   │   │           ├── StudentService.java       # Student business logic
│   │   │           ├── CourseService.java        # Course business logic
│   │   │           ├── EnrollmentService.java    # Enrollment business logic
│   │   │           └── PerformanceService.java   # Performance calculations
│   │   └── resources/
│   │       ├── static/                           # Static assets (CSS, JS, images)
│   │       ├── templates/                        # Thymeleaf templates
│   │       │   ├── index.html                    # Home page
│   │       │   ├── students.html                 # Student management
│   │       │   ├── courses.html                  # Course management
│   │       │   ├── enrollments.html              # Enrollment management
│   │       │   ├── performance.html              # Performance dashboard
│   │       │   ├── fragments/                    # Reusable template fragments
│   │       │   │   └── navbar.html               # Navigation bar
│   │       │   └── create_*.html                 # Create forms
│   │       │   └── edit_*.html                   # Edit forms
│   │       └── application.properties            # Application configuration
│   └── test/                                     # Unit and integration tests
├── pom.xml                                       # Maven configuration
└── README.md                                     # This file
```

## 🔗 API Endpoints

### Student Management
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/students` | List all students |
| GET | `/students/new` | Show create student form |
| POST | `/students` | Create new student |
| GET | `/students/edit/{id}` | Show edit student form |
| POST | `/students/{id}` | Update student |
| GET | `/students/delete/{id}` | Delete student |

### Course Management
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/courses` | List all courses |
| GET | `/courses/new` | Show create course form |
| POST | `/courses` | Create new course |
| GET | `/courses/edit/{id}` | Show edit course form |
| POST | `/courses/{id}` | Update course |
| GET | `/courses/delete/{id}` | Delete course |

### Enrollment Management
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/enrollments` | List all enrollments |
| GET | `/enrollments/new` | Show create enrollment form |
| POST | `/enrollments` | Create new enrollment |
| GET | `/enrollments/{id}` | View enrollment details |
| GET | `/enrollments/edit/{id}` | Show edit enrollment form |
| POST | `/enrollments/update/{id}` | Update enrollment |
| GET | `/enrollments/delete/{id}` | Delete enrollment |
| GET | `/enrollments/student/{id}` | View student's enrollments |

### Performance Analytics
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/performance` | View performance dashboard |

### System
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/` | Home page |
| GET | `/h2-console` | H2 database console |

## 🗄 Database Schema

### Student Table
```sql
CREATE TABLE student (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);
```

### Course Table
```sql
CREATE TABLE course (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    course_name VARCHAR(255) NOT NULL,
    description VARCHAR(255)
);
```

### Enrollment Table
```sql
CREATE TABLE enrollment (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    student_id BIGINT NOT NULL,
    course_id BIGINT NOT NULL,
    grade VARCHAR(255),
    FOREIGN KEY (student_id) REFERENCES student(id),
    FOREIGN KEY (course_id) REFERENCES course(id)
);
```

## 📖 User Guide

### Getting Started
1. **Access the Application**: Open http://localhost:8088 in your browser
2. **Follow the Workflow**: Use the numbered steps on the home page
3. **Start with Students**: Add student records first
4. **Add Courses**: Create course offerings
5. **Manage Enrollments**: Link students to courses
6. **View Performance**: Analyze student performance data

### Student Management
1. Navigate to "Manage Students"
2. Click "Add New Student" to create records
3. Use "Edit" to modify existing students
4. Use "Delete" to remove students
5. Email addresses must be unique across all students

### Course Management
1. Navigate to "Manage Courses"
2. Click "Add New Course" to create offerings
3. Provide course name and description
4. Edit or delete courses as needed

### Enrollment Management
1. Navigate to "Manage Enrollments"
2. Click "Add New Enrollment" to link students and courses
3. Select student and course from dropdowns
4. Assign grades to completed enrollments
5. View enrollment details and edit as needed

### Performance Analytics
1. Navigate to "Student Performance"
2. View GPA calculations and pass rates
3. See individual course grades
4. Monitor overall class performance

## 📸 Screenshots

### Home Page
Beautiful gradient background with step-by-step workflow cards featuring:
- Student management with user icons
- Course management with book icons
- Enrollment management with clipboard icons
- Performance analytics with chart icons

### Student Management
- Clean table layout with action buttons
- Form validation with error messages
- Responsive design for all screen sizes

### Performance Dashboard
- Individual student cards with GPA
- Color-coded pass rate indicators
- Progress bars and visual analytics
- Course-by-course grade breakdown

## 🤝 Contributing

We welcome contributions! Please follow these steps:

### Development Setup
1. Fork the repository
2. Create a feature branch: `git checkout -b feature-name`
3. Make your changes
4. Run tests: `mvn test`
5. Commit your changes: `git commit -am 'Add feature'`
6. Push to the branch: `git push origin feature-name`
7. Submit a pull request

### Code Style
- Follow Java naming conventions
- Use meaningful variable and method names
- Add comments for complex logic
- Write unit tests for new features

### Testing
```bash
# Run unit tests
mvn test

# Run integration tests
mvn verify

# Generate test coverage report
mvn jacoco:report
```

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 📞 Contact

**Project Maintainer**: [Your Name]
- **Email**: your.email@example.com
- **GitHub**: https://github.com/your-username
- **LinkedIn**: https://linkedin.com/in/your-profile

### Support
- **Issues**: [GitHub Issues](https://github.com/your-username/student-management-portal/issues)
- **Discussions**: [GitHub Discussions](https://github.com/your-username/student-management-portal/discussions)
- **Documentation**: [Wiki](https://github.com/your-username/student-management-portal/wiki)

---

## 🎓 Learning Outcomes

This project demonstrates key concepts from the Spring Boot curriculum:

### Day 1-2: Java & Web Fundamentals
- Object-oriented programming principles
- HTML/CSS responsive design
- Database fundamentals with SQL

### Day 3-4: Spring Boot Basics
- Spring Boot project structure
- Dependency injection
- MVC architecture

### Day 5-6: Database Integration
- JPA entity relationships
- Repository pattern
- Database constraints and validation

### Day 7-8: Advanced Features
- Thymeleaf templating
- Form validation
- Error handling
- REST principles

### Day 9-10: Production Ready
- Testing strategies
- Performance optimization
- Deployment considerations
- Security best practices

---

**⭐ Star this repository if you found it helpful!**

## Project Structure
```
src/
├── main/
│   ├── java/
│   │   └── com/example/sms/
│   │       ├── Application.java          # Main application class
│   │       ├── controller/               # Controllers
│   │       ├── entity/                   # JPA entities
│   │       ├── repository/               # JPA repositories
│   │       └── service/                  # Service layer
│   └── resources/
│       ├── static/                       # Static assets
│       ├── templates/                    # Thymeleaf templates
│       └── application.properties        # Configuration
pom.xml                                   # Maven configuration
```

## Technologies Used
- Spring Boot 3.2.0
- Spring Data JPA
- H2 Database
- Thymeleaf
- Bootstrap
