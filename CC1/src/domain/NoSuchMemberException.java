package domain;

public class NoSuchMemberException extends RuntimeException {
    public NoSuchMemberException(String message) {
        super(message);
    }

    public static NoSuchMemberException withId(MemberId memberId) {
        return new NoSuchMemberException("No member found with ID " + memberId.getValue());
    }
}
