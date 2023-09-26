package com.esop.Esop_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "FAQ")
public class FAQ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String question;
    private String answer;

}

//1. What is an ESOP (Employee Stock Ownership Plan)?
//
//        An ESOP is a retirement plan that allows employees to become partial owners of the company by acquiring shares.
//        2. How does an ESOP benefit me as an employee?
//
//        An ESOP provides an opportunity for potential financial gain as the company grows and helps create a sense of ownership and alignment with the company's success.
//        3. Who is eligible to participate in the ESOP Scheme?
//
//        Generally, all full-time employees who meet the specific eligibility criteria set by the company can participate in the ESOP Scheme.
//        4. How are ESOP shares allocated to employees?
//
//        ESOP shares are allocated based on various factors, including employee compensation and years of service.
//        5. What is a vesting period in an ESOP?
//
//        A vesting period is the duration an employee must work for the company before gaining full ownership rights to the allocated ESOP shares.
//        6. How does the vesting schedule work?
//
//        The vesting schedule determines when and how much of the allocated ESOP shares become fully owned by the employee over time.
//        7. Can I sell my ESOP shares before the vesting period is completed?
//
//        Usually, no. ESOP shares are subject to a vesting schedule, and selling before completing the vesting period may result in forfeiture of unvested shares.
//        8. Can I purchase additional ESOP shares beyond the allocated amount?
//
//        It depends on the rules and policies of the ESOP Scheme. Some plans allow employees to purchase additional shares.
//        9. How are the ESOP shares priced for purchase?
//
//        ESOP shares are typically priced at a discounted value compared to the market price, encouraging employee participation.
//        10. What happens to my ESOP shares if I leave the company?
//
//        The treatment of ESOP shares upon leaving the company depends on the company's policies. Generally, you may have options to sell, transfer, or retain the shares.
//        11. Can I participate in the ESOP Scheme if I'm part-time or a contract employee?
//
//        Eligibility for the ESOP Scheme often depends on the company's policies and the terms of the plan.
//        12. Are ESOP contributions tax-deductible for the company?
//
//        Yes, ESOP contributions made by the company are generally tax-deductible, subject to tax laws and regulations.
//        13. Can I allocate my ESOP shares to a beneficiary in case of my passing?
//
//        Yes, you can typically designate a beneficiary to receive your ESOP shares in the event of your death.
//        14. Can I diversify my ESOP shares into other investments?
//
//        Some ESOP plans offer options for diversification, allowing you to move a portion of your ESOP account into other investments.
//        15. How often can I purchase ESOP shares?
//
//        The frequency of ESOP share purchases may vary depending on the company's ESOP plan rules, but it's usually defined by specific purchase windows.
//        16. Can the company buy back my ESOP shares?
//
//        Yes, many ESOP plans allow the company to buy back ESOP shares from employees, especially upon retirement or termination.
//        17. What is a "put option" related to ESOP shares?
//
//        A put option is an agreement that allows an ESOP participant to sell their shares back to the company at a predetermined price and time.
//        18. Can I participate in the ESOP Scheme if I'm nearing retirement?
//
//        Yes, ESOP participation is often open to employees nearing retirement, and the plan may have specific provisions for them.
//        19. Can ESOP shares be transferred to my family members?
//
//        Depending on the plan rules and company policies, ESOP shares may be transferable to certain family members.
//        20. How does an ESOP affect the company's governance and decision-making process?
//
//        An ESOP can influence governance by giving employees a voice in certain decisions, often through their representatives on the company's board of directors or trustee. However, it does not grant individual employees direct control over day-to-day operations.