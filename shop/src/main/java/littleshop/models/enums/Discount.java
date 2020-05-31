package littleshop.models.enums;

import java.math.BigDecimal;

public enum Discount {

    REGULAR {
        public BigDecimal percents() {
            return BigDecimal.valueOf(5L);
        }
    },

    GOLD{
        public BigDecimal percents() {
            return BigDecimal.valueOf(20L);
        }
    }

}
