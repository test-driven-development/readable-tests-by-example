package tech.allegro.blog.vinyl.shop.common.money

import groovy.transform.CompileStatic
import groovy.transform.builder.Builder
import groovy.transform.builder.SimpleStrategy

@CompileStatic
@Builder(builderStrategy = SimpleStrategy, prefix = "with")
class MoneyBuilder {
    BigDecimal amount
    String currency

    static MoneyBuilder euro(BigDecimal amount) {
        return new MoneyBuilder(amount: amount, currency: "EUR")
    }

    Money build() {
        return Money.of(amount, Currency.getInstance(currency))
    }
}