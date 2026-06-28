package dev.ia;

import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService
public interface TravelAgentAssistant {


    String chat(String message);
}
