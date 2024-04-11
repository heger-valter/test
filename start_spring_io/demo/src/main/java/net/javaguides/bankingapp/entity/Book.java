package net.javaguides.bankingapp.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private boolean borrowed;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User borrowedBy;
	public void setBorrowedBy(User user) {
		// TODO Auto-generated method stub
		borrowedBy=user;
	}
	public void setBorrowed(boolean b) {
		// TODO Auto-generated method stub
		borrowed=b;
	}
	public boolean isBorrowed() {
		// TODO Auto-generated method stub
		return borrowed;
	}
}