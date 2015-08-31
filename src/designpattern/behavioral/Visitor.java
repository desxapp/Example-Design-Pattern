package designpattern.behavioral;

import designpattern.util.BasedPattern;

public class Visitor implements BasedPattern {
	@Override
	public void TestPattern() {
		Service service = new Service();
		service.doService(new Member());
	}

	interface IVisitable {
		void accept(IVisitor visitor);
	}

	interface IVisitor {
		void visit(Member member);

		void visit(VIP vip);
	}

	class Customer implements IVisitable {
		void doCustomer() {
			System.out.println("Customer service ");
		}

		void pay() {
			System.out.println("Checkout");
		}

		public void accept(IVisitor visitor) {
			// nothing to do
		}
	}

	class Member extends Customer {
		void doMember() {
			System.out.println("Member Services");
		}

		@Override
		public void accept(IVisitor visitor) {
			visitor.visit(this); // overload
		}
	}

	class VIP extends Customer {
		void doVIP() {
			System.out.println("VIP Service");
		}

		@Override
		public void accept(IVisitor visitor) {
			visitor.visit(this); // overload
		}
	}

	class VisitorImpl implements IVisitor {
	    public void visit(Member member) {
	        member.doMember();
	    }
	    public void visit(VIP vip) {
	        vip.doVIP();
	    }
	}

	class Service {
	    private IVisitor visitor = new VisitorImpl();
	    void doService(Customer customer) {
	        customer.doCustomer();
	        ((IVisitable) customer).accept(visitor);
	        customer.pay();
	    }
	}


}
