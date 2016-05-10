import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.idnoll.controllers.QuizController;
import com.idnoll.models.QuestionModel;;

public class CheckNumberOfRightAnswersTest {
	
	List<String> userAnswersCorrect;
	List<String> userAnswersFalse;
	
	QuizController quizController;
	
	
	@Before
	public void setup(){
		quizController = new QuizController();
		quizController.questions.add(new QuestionModel("Vad är 1+1","2","3","4","Matte",0L));
		
		userAnswersCorrect = new ArrayList<>();
		userAnswersCorrect.add("2");
		
		userAnswersFalse = new ArrayList<>();
		userAnswersFalse.add("3");

	}
	
	@Test
	public void testAnswers() {	
		Integer expectedNumberOfRightResult = 1;
		assertEquals(expectedNumberOfRightResult, quizController.checkNumberOfRightAnswers(userAnswersCorrect));

		expectedNumberOfRightResult = 0;
		assertEquals(expectedNumberOfRightResult, quizController.checkNumberOfRightAnswers(userAnswersFalse));
	}
}
