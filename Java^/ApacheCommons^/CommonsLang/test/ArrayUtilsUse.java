import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class ArrayUtilsUse {

    @Test
    public void main() {
        int[] arr = {100, 200};
        assertFalse(ArrayUtils.isEmpty(arr));
    }
}