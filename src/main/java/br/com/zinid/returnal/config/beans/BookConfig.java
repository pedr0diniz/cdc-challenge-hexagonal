package br.com.zinid.returnal.config.beans;

import br.com.zinid.returnal.adapter.book.output.SaveBookService;
import br.com.zinid.returnal.application.domain.book.BookInputPort;
import br.com.zinid.returnal.application.domain.book.CreateBookUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookConfig {

    @Bean
    public BookInputPort createBookInputPort(SaveBookService saveBookService) {
        return new CreateBookUseCase(saveBookService);
    }
}
