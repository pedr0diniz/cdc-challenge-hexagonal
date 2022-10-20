package br.com.zinid.returnal.config.beans;

import br.com.zinid.returnal.adapter.book.output.GetBookDetailsAdapter;
import br.com.zinid.returnal.adapter.book.output.GetBookListAdapter;
import br.com.zinid.returnal.adapter.book.output.CreateBookAdapter;
import br.com.zinid.returnal.application.domain.book.input.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookConfig {

    @Bean
    public CreateBookInputPort createBookInputPort(CreateBookAdapter createBookAdapter) {
        return new CreateBookUseCase(createBookAdapter);
    }

    @Bean
    public GetBookListInputPort createGetBookListInputPort(GetBookListAdapter getBookListAdapter) {
        return new GetBookListUseCase(getBookListAdapter);
    }

    @Bean
    public GetBookDetailsInputPort createGetBookDetailsInputPort(GetBookDetailsAdapter getBookDetailsAdapter) {
        return new GetBookDetailsUseCase(getBookDetailsAdapter);
    }
}
