package spring;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.annotation.Nullable;

public class MemberPrinter {
	private DateTimeFormatter dateTimeFormatter;

	public void print(Member member) {
		if(dateTimeFormatter == null) {
			System.out.printf(
						"회원 정보:아이디=%d, 이메일=%s, 이름=%s, 등록일=%tF\n",
						member.getId(), member.getEmail(),
						member.getName(), member.getRegisterDateTime()
					);
		}
		System.out.printf(
				"회원 정보:아이디=%d, 이메일=%s, 이름=%s, 등록일=%s\n",
				member.getId(), member.getEmail(), 
				member.getName(), 
				dateTimeFormatter.format(member.getRegisterDateTime())
				);
	}
	
	@Autowired(required = false)
	public void setDateFormatter(@Nullable DateTimeFormatter formatterOpt) {
		this.dateTimeFormatter = dateTimeFormatter;
	}
	
}
