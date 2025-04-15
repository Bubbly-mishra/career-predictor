# Career Predictor - SQL Schema & Data Seed

This SQL script sets up the database schema and seed data for the **Career Predictor** application. It includes:

- Table creation for `question` and `answer`.
- Insertion of 20 categorized questions.
- Five standard Likert scale responses for each question.

---

## 📦 Tables Created

### `question`
Stores the question text and category.

| Column     | Type         | Description                        |
|------------|--------------|------------------------------------|
| `id`       | BIGINT       | Primary key, auto-increment        |
| `text`     | VARCHAR(500) | The question itself                |
| `category` | VARCHAR(50)  | Category (e.g., analytical, social)|

### `answer`
Stores possible answers for each question.

| Column       | Type         | Description                            |
|--------------|--------------|----------------------------------------|
| `id`         | BIGINT       | Primary key, auto-increment            |
| `question_id`| BIGINT       | Foreign key referencing `question(id)` |
| `text`       | VARCHAR(100) | Response text (e.g., Agree)            |
| `value`      | INT          | Numeric value of the response (1-5)    |

---

## 🧠 Question Categories

| Category     | Description                                  |
|--------------|----------------------------------------------|
| analytical   | Logical reasoning and problem-solving         |
| creative     | Artistic and innovative thinking              |
| social       | Interpersonal and communication skills        |
| leadership   | Leading, delegating, and decision-making      |
| detail       | Organizational skills and attention to detail |

---

## 📋 Sample Question & Answer Format

### Example (Analytical):
**Question:**  
_I enjoy solving complex problems_  
**Answers:**
- Strongly Disagree (1)
- Disagree (2)
- Neutral (3)
- Agree (4)
- Strongly Agree (5)

---

## ▶️ How to Use

1. **Create a MySQL database** (e.g., `career_predictor_db`)
2. **Run this script** in a MySQL client or terminal to initialize schema and data.
3. Your Spring Boot application will map to these tables via JPA entities.

---

## 💡 Notes

- Make sure your Spring Boot project includes the correct `@Entity` annotations.
- Configure the database connection in `application.properties` or `application.yml`:
  ```properties
  spring.datasource.url=jdbc:mysql://localhost:3306/career_predictor_db
  spring.datasource.username=YOUR_USERNAME
  spring.datasource.password=YOUR_PASSWORD
  spring.jpa.hibernate.ddl-auto=none
  spring.jpa.show-sql=true
