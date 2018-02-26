(load "~/quicklisp/setup.lisp")
(ql:quickload "cl-utilities")

(defun has-duplicates (list)
  (not (= (length list) (length (remove-duplicates list :test #'equal)))))

(defun sort-letters-in-words(words)
  (loop for word in words collecting (sort word #'char-lessp)))

(defun split-string (string)
(cl-utilities:split-sequence #\Space string))

(defun check-passphrase (phrase)
  (not (has-duplicates (split-string phrase))))

(defun check-passphrase-enhanced (phrase)
  (not (has-duplicates (sort-letters-in-words (split-string phrase)))))

(defun count-correct-passphrases (path &optional (check-p #'check-passphrase))
  (with-open-file (input path)
    (loop for line = (read-line input nil)
      while line count (funcall check-p line))))


; (count-correct-passphrases "input.txt")
; (count-correct-passphrases "input.txt" #'check-passphrase-enhanced)
