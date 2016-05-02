/*import static org.junit.Assert.*;

import org.junit.Test;

import com.idnoll.controllers.QuizController;

public class CheckCorrectAnswerTest {

	QuizController quizController = new QuizController();
	
	@Test
	public void testAnswers() {
		//quizController.populateListWithQuestions();
		quizController.questions.get(0).setUserAnswer("Kobe");
		quizController.questions.get(1).setUserAnswer("Memorial Cup");
		assertEquals(true, quizController.checkIfRightAnswer(0));
		assertEquals(false, quizController.checkIfRightAnswer(1));
	}

}*/
