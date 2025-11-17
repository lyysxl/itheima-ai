package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * UserService类的单元测试
 * Unit tests for UserService class
 */
class UserServiceAiTest {

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService();
    }

    // ==================== getAge方法测试 ====================

    /**
     * 测试正常情况下的年龄计算
     * Test age calculation with valid ID card
     */
    @Test
    @DisplayName("测试有效身份证号计算年龄")
    void testGetAgeWithValidIdCard() {
        // 假设当前年份为2024年，测试1990年出生的人
        String idCard = "110101199001011234"; // 1990年1月1日出生
        Integer age = userService.getAge(idCard);
        assertNotNull(age);
        // 根据实际运行时的当前日期计算预期年龄
        assertTrue(age >= 30 && age <= 40); // 粗略验证范围
    }

    /**
     * 测试null输入的情况
     * Test null input exception handling
     */
    @Test
    @DisplayName("测试null身份证号抛出异常")
    void testGetAgeWithNullIdCard() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> userService.getAge(null),
                "应该抛出IllegalArgumentException异常"
        );
        assertEquals("无效的身份证号码", exception.getMessage());
    }

    /**
     * 测试长度不正确的身份证号
     * Test invalid length ID card exception handling
     */
    @Test
    @DisplayName("测试长度不正确的身份证号抛出异常")
    void testGetAgeWithInvalidLengthIdCard() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> userService.getAge("123456789012345"), // 15位
                "应该抛出IllegalArgumentException异常"
        );
        assertEquals("无效的身份证号码", exception.getMessage());
    }

    /**
     * 测试空字符串输入
     * Test empty string input
     */
    @Test
    @DisplayName("测试空字符串身份证号抛出异常")
    void testGetAgeWithEmptyString() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> userService.getAge(""),
                "应该抛出IllegalArgumentException异常"
        );
        assertEquals("无效的身份证号码", exception.getMessage());
    }

    // ==================== getGender方法测试 ====================

    /**
     * 测试第17位为奇数时返回男性
     * Test gender calculation when 17th digit is odd (male)
     */
    @Test
    @DisplayName("测试第17位为奇数时返回男性")
    void testGetGenderWithMale() {
        String idCard = "110101199001011235"; // 第17位是5(奇数)
        String gender = userService.getGender(idCard);
        assertEquals("男", gender);
    }

    /**
     * 测试第17位为偶数时返回女性
     * Test gender calculation when 17th digit is even (female)
     */
    @Test
    @DisplayName("测试第17位为偶数时返回女性")
    void testGetGenderWithFemale() {
        String idCard = "110101199001011244"; // 第17位是4(偶数)
        String gender = userService.getGender(idCard);
        assertEquals("女", gender);
    }

    /**
     * 测试null输入的情况
     * Test null input exception handling for gender method
     */
    @Test
    @DisplayName("测试null身份证号获取性别抛出异常")
    void testGetGenderWithNullIdCard() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> userService.getGender(null),
                "应该抛出IllegalArgumentException异常"
        );
        assertEquals("无效的身份证号码", exception.getMessage());
    }

    /**
     * 测试长度不正确的身份证号获取性别
     * Test invalid length ID card for gender method
     */
    @Test
    @DisplayName("测试长度不正确的身份证号获取性别抛出异常")
    void testGetGenderWithInvalidLengthIdCard() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> userService.getGender("123456789012345"), // 15位
                "应该抛出IllegalArgumentException异常"
        );
        assertEquals("无效的身份证号码", exception.getMessage());
    }

    /**
     * 参数化测试：测试多种男性身份证号
     * Parameterized test for multiple male ID cards
     */
    @ParameterizedTest
    @ValueSource(strings = {
            "110101199001011231",
            "110101199001011233",
            "110101199001011235",
            "110101199001011237",
            "110101199001011239"
    })
    @DisplayName("参数化测试男性身份证号")
    void testMultipleMaleIdCards(String idCard) {
        String gender = userService.getGender(idCard);
        assertEquals("男", gender);
    }

    /**
     * 参数化测试：测试多种女性身份证号
     * Parameterized test for multiple female ID cards
     */
    @ParameterizedTest
    @ValueSource(strings = {
            "110101199001011220",
            "110101199001011222",
            "110101199001011224",
            "110101199001011226",
            "110101199001011228"
    })
    @DisplayName("参数化测试女性身份证号")
    void testMultipleFemaleIdCards(String idCard) {
        String gender = userService.getGender(idCard);
        assertEquals("女", gender);
    }
}
