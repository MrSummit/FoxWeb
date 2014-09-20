class Student < ActiveRecord::Base
	require 'digest/sha2'
	belongs_to :grade

	validates :number,:presence=>true,:uniqueness=>true
	validates :pswd,:confirmation=>true
	attr_accessor :pswd_confirmation
	attr_reader :pswd

	validate :password_must_be_present

	def Student.encrypt_password(pswd,salt)
		Digest::SHA2.hexdigest(pswd+"wibble"+salt)
	end

	def pswd=(pswd)
		@pswd=pswd
		if pswd.present?
			generate_salt
			self.password=self.class.encrypt_password(pswd,salt)
		end
	end

	def Student.authenticate(number,pswd)
		if student=find_by_number(number)
			if student.password==encrypt_password(pswd,student.salt)
				student
			end
		end
	end
	private 
	def generate_salt
		self.salt=self.object_id.to_s+rand.to_s
	end
	def password_must_be_present
		errors.add(:pswd,"missing password") unless password.present?
	end
end
