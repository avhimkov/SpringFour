DELIMITER //
CREATE FUNCTION getFirstNameByld(in_id INT)
RETURNS VARCНAR (60)
BEGIN
RETURN (SELECT first name FROM contact WHERE id = in_id);
END //
DELIMITER;