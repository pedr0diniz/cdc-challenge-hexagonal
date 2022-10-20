package br.com.zinid.returnal.config.beans;

import br.com.zinid.returnal.adapter.book.output.GetBookListAdapter;
import br.com.zinid.returnal.adapter.book.output.CreateBookAdapter;
import br.com.zinid.returnal.application.domain.book.input.CreateBookInputPort;
import br.com.zinid.returnal.application.domain.book.input.CreateBookUseCase;
import br.com.zinid.returnal.application.domain.book.input.GetBookListInputPort;
import br.com.zinid.returnal.application.domain.book.input.GetBookListUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookConfig {

    @Bean
    public CreateBookInputPort createBookInputPort(CreateBookAdapter createBookAdapter) {
        return new CreateBookUseCase(createBookAdapter);
    }

    @Bean
    GetBookListInputPort createGetBookListInputPort(GetBookListAdapter getBookListAdapter) {
        return new GetBookListUseCase(getBookListAdapter);
    }
}
