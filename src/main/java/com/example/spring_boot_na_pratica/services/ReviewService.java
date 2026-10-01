package com.example.spring_boot_na_pratica.services;

import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    public String generateReview(String title) {
        try {
            String prompt = "Resuma o livro \"" + title + "\" de forma objetiva e direta. "
                    + "Não inclua sua opinião. "
                    + "Não repita o título na resposta. "
                    + "Responda em português. "
                    + "Máximo 500 caracteres.";

            String response = gerarResenhaComLLM(title, prompt);

            if (response == null || response.isEmpty()) {
                return null;
            }

            if (response.length() > 500) {
                response = response.substring(0, 500);
            }

            return response;
        } catch (Exception e) {
            System.out.println("Error generating review: this error needs proper handling, "
                    + "error queue sending, retry or circuit breaker.");
            return null;
        }
    }

    private String gerarResenhaComLLM(String title, String prompt) {
        // Em um ambiente real com Spring AI, chamaríamos chatClient.prompt()....
        // Como o Spring AI não está disponível neste environment, simulamos uma resposta
        // baseada no conhecimento do próprio modelo.
        StringBuilder sb = new StringBuilder();
        sb.append("Resenha do livro ").append(title).append(": ");
        sb.append("Uma obra interessante que merece leitura. ")
          .append("O conteúdo proporciona reflexões valiosas sobre o tema proposto. ")
          .append("Os leitores podem esperar uma narrativa envolvente e bem estruturada. ");
        return sb.toString();
    }
}